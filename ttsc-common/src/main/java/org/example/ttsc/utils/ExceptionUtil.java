package org.example.ttsc.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @Title: ExceptionUtil
 * @Description: 异常工具类
 * @Author: RodgerLz
 * @Date: 2020/8/3 17:39
 * @Version: 1.0
 */
public class ExceptionUtil {
    /**
     * 获取异常的堆栈信息
     *
     * @param t
     * @return
     */
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            t.printStackTrace(pw);
            return sw.toString();
        } finally {
            pw.close();
        }
    }
}
