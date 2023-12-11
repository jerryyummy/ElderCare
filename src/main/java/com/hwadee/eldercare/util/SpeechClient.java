package com.hwadee.eldercare.util;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;

import java.io.IOException;
import java.util.UUID;

public class SpeechClient {
    private static volatile SpeechClient speechClient;
    private final AipSpeech client;

    private SpeechClient(String APP_ID, String API_KEY, String SECRET_KEY) {
        client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
    }

    public static SpeechClient getInstance(String APP_ID, String API_KEY, String SECRET_KEY) {
        if (speechClient == null) {
            synchronized (SpeechClient.class) {
                if (speechClient == null) {
                    speechClient = new SpeechClient(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return speechClient;
    }

    public String generateMp3(String text, String path) { // text文本内容， path是保存的文件路径
        String name = null;
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        TtsResponse res = client.synthesis(text, "zh", 1, null);
        System.out.println(res.getResult());
        byte[] data = res.getData();  // 得到的是生成的语音的二进制数据
        //定义变量调用转换格式
        if (data != null) {
            try {
                // uuid是为了规避文件名冲突
                name = UUID.randomUUID() + ".mp3";
                String fileName = path + "/" + name;
                Util.writeBytesToFileSystem(data, fileName); // 将语音数据保存成mp3文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return name;
    }
}