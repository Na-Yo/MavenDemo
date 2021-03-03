package chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuziwen
 * @date 2021/3/3 9:40 下午
 */
public class Main {
    public static void main(String[] args) {
        Request request = new Request();
        request.msg="request:";
        Response response = new Response();
        response.msg="response:";
        FilterChain filterChain = new FilterChain();
        filterChain.add(new FilterOne()).add(new FilterTwo());
        filterChain.doFilter(request,response);
        System.out.println(request.msg);
        System.out.println(response.msg);
    }


}


class Request{
    String msg;
}

class Response{
    String msg;
}

class FilterChain{
    List<Filter> filters=new ArrayList<>();
    int index=0;

    FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    /**
     * 过滤器
     * @param request
     * @param response
     */
    public void doFilter(Request request, Response response){
        if(index == filters.size()){
            return;
        }
        Filter filter = filters.get(index);
        index++;
        filter.doFilter(request,response,this);
    };
}

interface Filter{
    /**
     * 过滤器，通过chain
     * @param request
     * @param response
     * @param chain
     */
    public void doFilter(Request request, Response response,
                         FilterChain chain);
}

class FilterOne implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.msg=request.msg+"---FilterOne";
        chain.doFilter(request,response);
        response.msg=response.msg+"---FilterOne";
    }
}

class FilterTwo implements Filter{

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        request.msg=request.msg+"---FilterTwo";
        chain.doFilter(request,response);
        response.msg=response.msg+"---FilterTwo";
    }
}