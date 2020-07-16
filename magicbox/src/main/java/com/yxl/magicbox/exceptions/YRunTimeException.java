package com.yxl.magicbox.exceptions;

/**
 * 定义一个运行时异常、用于抛出异常、异常详情、异常原因
 */
public class YRunTimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private Object[] args;
    private String detail;

    public Object[] getArgs() {
        return args;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public YRunTimeException(String message){
        super(message);
    }
    public YRunTimeException(String message,Throwable cause){
        super(message, cause);
    }
    public YRunTimeException(String message,Throwable cause,Object[] args){
        super(message, cause);
        this.args = args;
    }
    public YRunTimeException(String message,Object[] args){
        super(message);
        this.args = args;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(super.toString());
        if(this.detail!=null){
            sb.append(" ").append(this.detail).append(" ");
        }
        if(this.args!=null){
            sb.append(" Args:");
            for(int i=0;i<args.length;i++){
                sb.append(args[i]).append(" ");
            }
        }
        if(this.getCause()!=null){
            sb.append(" Cause:").append(this.getCause().toString());
        }
        return sb.toString();
    }
}
