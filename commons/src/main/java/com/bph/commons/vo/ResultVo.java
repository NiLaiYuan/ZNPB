package com.bph.commons.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVo {
    /**
     * 状态码   1:接收并完成请求   2:接收请求但执行失败  3:接收请求但参数错误
     */
    private int scode;
    /**
     * 提示信息(可能是成功信息，也可能是失败信息)
     */
    private String emessage;
    /**
     * 返回给前端的数据(一个json对象)
     */
    private Object rdata;

    /**
     * 成功
     * @param data
     * @return
     */
    private static ResultVo ok(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setScode(1);
        resultVo.setEmessage("ok");
        resultVo.setRdata(data);
        return resultVo;
    }

    private static ResultVo ok(){
        return ResultVo.ok(null);
    }

    /**
     * 失败
     */
    private static ResultVo error(){
        ResultVo resultVo = new ResultVo();
        resultVo.setScode(500);
        resultVo.setEmessage("error");
        return resultVo;
    }

    public static ResultVo getSuccessVo(String msg, Object data) {
        ResultVo resultVO = new ResultVo();
        resultVO.setScode(1);
        resultVO.setEmessage(msg);
        resultVO.setRdata(data);
        return resultVO;
    }


    public static ResultVo getFailVo(String error, String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setScode(500);
        resultVO.setEmessage(error+msg);
        return resultVO;
    }

}
