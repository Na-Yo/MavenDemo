/*
	Copyright (C) 2016 Shanghai Huizhao e-Bidding Services Co., Ltd.
	All rights reserved.

	Author: WGY
	Version: 1.0
	Created Time: 2016年12月12日 上午9:46:56
	
	Revision History:
	Version          Date               Author			Comments
	1.0         	2016年12月12日上午9:46:56		WGY			Create file
=========================================================================
*/

package com.xuzw.util;

import org.apache.http.conn.ssl.TrustStrategy;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


class AnyTrustStrategy implements TrustStrategy {

	/* (non-Javadoc)
	 * @see org.apache.http.ssl.TrustStrategy#isTrusted(java.security.cert.X509Certificate[], java.lang.String)
	 */
	public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
		return true;
	}
	
}

