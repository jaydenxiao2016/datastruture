package datastruture.jaydenxiao.com.datastruture.lsn_20;

import org.apache.commons.codec.digest.Sha2Crypt;
import org.junit.Test;

/**
 * 类名：
 * 描述：SHA
 * 作者：xsf
 * 创建时间：2018/12/9
 * 最后修改时间：2018/12/9
 */
public class SHA {
    @Test
    public void test(){
        String result= Sha2Crypt.sha256Crypt("jett".getBytes());
        System.out.println(result);
    }
}
