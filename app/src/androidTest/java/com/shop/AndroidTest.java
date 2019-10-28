package com.shop;

import android.support.test.runner.AndroidJUnit4;
import android.util.Base64;
import android.util.Log;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

@RunWith(AndroidJUnit4.class)
public class AndroidTest {

    @Test
    public void testRsa() throws Exception{

        Map<String,String> map = new HashMap<>();
        map.put("phone","13551145345");

        Login login = new Login();

        String key = login.getSign(map);

        Log.i("str",key);

        //Login login = new Login();
        //login.startLogin();

        //初始化密钥
        //生成密钥对
        Map<String,Object> keyMap = MyRsa.initKey();
        //公钥
        byte[] publicKey = MyRsa.getPublicKey(keyMap);

        //私钥
        byte[] privateKey = MyRsa.getPrivateKey(keyMap);
        System.out.println("公钥：/n" + Base64.encodeToString(publicKey, Base64.DEFAULT));
        System.out.println("私钥：/n" + Base64.encodeToString(privateKey, Base64.DEFAULT));

        System.out.println("================密钥对构造完毕,甲方将公钥公布给乙方，开始进行加密数据的传输=============");
        String str = "RSA密码交换算法";
        System.out.println("/n===========甲方向乙方发送加密数据==============");
        System.out.println("原文:$str");
        //甲方进行数据的加密
        byte[] code1 = MyRsa.encryptByPrivateKey(str.getBytes(), privateKey);
        System.out.println("加密后的数据：" + Base64.encodeToString(code1, Base64.DEFAULT));
        System.out.println("===========乙方使用甲方提供的公钥对数据进行解密==============");
        //乙方进行数据的解密
        byte[] decode1 = MyRsa.decryptByPublicKey(code1, publicKey);
        System.out.println("乙方解密后的数据：" + new String(decode1) + "/n/n");

        System.out.println("===========反向进行操作，乙方向甲方发送数据==============/n/n");

        String str1 = "乙方向甲方发送数据RSA算法";

        System.out.println("原文:$str");

        //乙方使用公钥对数据进行加密
        byte[] code2 = MyRsa.encryptByPublicKey(str.getBytes(), publicKey);
        System.out.println("===========乙方使用公钥对数据进行加密==============");
        System.out.println("加密后的数据：" + Base64.encodeToString(code2, Base64.DEFAULT));

        System.out.println("=============乙方将数据传送给甲方======================");
        System.out.println("===========甲方使用私钥对数据进行解密==============");

        //甲方使用私钥对数据进行解密
        byte[] decode2 = MyRsa.decryptByPrivateKey(code2, privateKey);

        System.out.println("甲方解密后的数据：" + new String(decode2));
    }

}
