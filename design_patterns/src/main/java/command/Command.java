package command;

/**
 * @author xuziwen
 * @date 2021/3/7 11:30 下午
 */
public abstract class Command {
    /**
     * 执行
     */
    public abstract void doIt();

    /**
     * 撤销
     */
    public abstract void undo();

}
