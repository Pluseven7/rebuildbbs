package com.rebuild.base;

import com.rebuild.utils.HttpResult;
import com.rebuild.utils.SysException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected HttpResult restProcessor(ResultProcessor processor){
        HttpResult result = null;
        try{
            result = processor.process();
        }
        catch (SysException e1){
            logger.error("ServiceProcess Error Log :"+e1.getLocalizedMessage(),e1);
            result = HttpResult.failResponse(e1.getMessage());
        }
        catch (Exception e){
            logger.error("Error Log :"+e.getLocalizedMessage(),e);
            result = HttpResult.failResponse("服务器出现异常");
        }

        return result;
    }
}
