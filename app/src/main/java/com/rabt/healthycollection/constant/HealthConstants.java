package com.rabt.healthycollection.constant;

import android.util.SparseArray;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.rabt.healthycollection.model.bean.DrugType;

import java.util.List;

/**
 * @author zjm
 * @Description:
 * @date 2016/11/21
 */

public class HealthConstants {
    public static final String HEALTHNEWS_ID = "healthnews_id";
    public static SparseArray<String> HEALTH_TYPE;
    public static List<DrugType> DRUG_TYPE;

    static {
        //健康资讯类别
        HEALTH_TYPE = new SparseArray<>();
        HEALTH_TYPE.put(1, "企业要闻");
        HEALTH_TYPE.put(2, "医药新闻");
        HEALTH_TYPE.put(3, "生活贴士");
        /*HEALTH_TYPE.put(4, "药品新闻");
        HEALTH_TYPE.put(5, "食品新闻");
        HEALTH_TYPE.put(6, "社会热点");*/

        //药品类别
        DRUG_TYPE = new Gson().fromJson("[\n" +
                        "{\n" +
                        "\"id\": \"55c761e35d84145c548a9a76\",\n" +
                        "\"type\": \"感冒发热\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e45d84145c548a9a77\",\n" +
                        "\"type\": \"男科用药\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e45d84145c548a9a78\",\n" +
                        "\"type\": \"肠胃用药\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e45d84145c548a9a79\",\n" +
                        "\"type\": \"妇科用药\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e45d84145c548a9a7a\",\n" +
                        "\"type\": \"皮肤用药\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e45d84145c548a9a7b\",\n" +
                        "\"type\": \"儿童用药\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a7c\",\n" +
                        "\"type\": \"五官用药\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a7d\",\n" +
                        "\"type\": \"老人用药\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a7e\",\n" +
                        "\"type\": \"保健食品\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a7f\",\n" +
                        "\"type\": \"滋补食品\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a80\",\n" +
                        "\"type\": \"骨科疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a81\",\n" +
                        "\"type\": \"心血管系统疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a82\",\n" +
                        "\"type\": \"男科疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a83\",\n" +
                        "\"type\": \"呼吸系统疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a84\",\n" +
                        "\"type\": \"儿科疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e55d84145c548a9a85\",\n" +
                        "\"type\": \"泌尿系统疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a86\",\n" +
                        "\"type\": \"外科疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a87\",\n" +
                        "\"type\": \"耳鼻咽喉疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a88\",\n" +
                        "\"type\": \"肿瘤疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a89\",\n" +
                        "\"type\": \"精神心理疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a8a\",\n" +
                        "\"type\": \"皮肤疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a8b\",\n" +
                        "\"type\": \"消化系统疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a8c\",\n" +
                        "\"type\": \"代谢疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a8d\",\n" +
                        "\"type\": \"口腔疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a8e\",\n" +
                        "\"type\": \"神经系统疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e65d84145c548a9a8f\",\n" +
                        "\"type\": \"性传播疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e75d84145c548a9a90\",\n" +
                        "\"type\": \"眼疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e75d84145c548a9a91\",\n" +
                        "\"type\": \"风湿免疫系统疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e75d84145c548a9a92\",\n" +
                        "\"type\": \"感染性疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e75d84145c548a9a93\",\n" +
                        "\"type\": \"内分泌系统疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e75d84145c548a9a94\",\n" +
                        "\"type\": \"女性生殖及妊娠疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e75d84145c548a9a95\",\n" +
                        "\"type\": \"血液和淋巴系统疾病\"\n" +
                        "},\n" +
                        "{\n" +
                        "\"id\": \"55c761e75d84145c548a9a96\",\n" +
                        "\"type\": \"维生素与矿物质\"\n" +
                        "}\n" +
                        "]",
                new TypeToken<List<DrugType>>() {
                }.getType());
        /*DRUG_TYPE = new HashMap<>();
        DRUG_TYPE.put("感冒发热", "55c761e35d84145c548a9a76");
        DRUG_TYPE.put("男科用药", "55c761e45d84145c548a9a77");
        DRUG_TYPE.put("肠胃用药", "55c761e45d84145c548a9a78");
        DRUG_TYPE.put("妇科用药", "55c761e45d84145c548a9a79");
        DRUG_TYPE.put("皮肤用药", "55c761e45d84145c548a9a7a");
        DRUG_TYPE.put("儿童用药", "55c761e45d84145c548a9a7b");
        DRUG_TYPE.put("五官用药", "55c761e55d84145c548a9a7c");
        DRUG_TYPE.put("老人用药", "55c761e55d84145c548a9a7d");
        DRUG_TYPE.put("保健食品", "55c761e55d84145c548a9a7e");
        DRUG_TYPE.put("滋补食品", "55c761e55d84145c548a9a7f");
        DRUG_TYPE.put("骨科疾病", "55c761e55d84145c548a9a80");
        DRUG_TYPE.put("心血管系统疾病", "55c761e55d84145c548a9a81");
        DRUG_TYPE.put("男科疾病", "55c761e55d84145c548a9a82");
        DRUG_TYPE.put("呼吸系统疾病", "55c761e55d84145c548a9a83");
        DRUG_TYPE.put("儿科疾病", "55c761e55d84145c548a9a84");
        DRUG_TYPE.put("泌尿系统疾病", "55c761e55d84145c548a9a85");
        DRUG_TYPE.put("外科疾病", "55c761e65d84145c548a9a86");
        DRUG_TYPE.put("耳鼻咽喉疾病", "55c761e65d84145c548a9a87");
        DRUG_TYPE.put("肿瘤疾病", "55c761e65d84145c548a9a88");
        DRUG_TYPE.put("精神心理疾病", "55c761e65d84145c548a9a89");
        DRUG_TYPE.put("皮肤疾病", "55c761e65d84145c548a9a8a");
        DRUG_TYPE.put("消化系统疾病", "55c761e65d84145c548a9a8b");
        DRUG_TYPE.put("代谢疾病", "55c761e65d84145c548a9a8c");
        DRUG_TYPE.put("口腔疾病", "55c761e65d84145c548a9a8d");
        DRUG_TYPE.put("神经系统疾病", "55c761e65d84145c548a9a8e");
        DRUG_TYPE.put("性传播疾病", "55c761e65d84145c548a9a8f");
        DRUG_TYPE.put("眼疾病", "55c761e75d84145c548a9a90");
        DRUG_TYPE.put("风湿免疫系统疾病", "55c761e75d84145c548a9a91");
        DRUG_TYPE.put("感染性疾病", "55c761e75d84145c548a9a92");
        DRUG_TYPE.put("内分泌系统疾病", "55c761e75d84145c548a9a93");
        DRUG_TYPE.put("女性生殖及妊娠疾病", "55c761e75d84145c548a9a94");
        DRUG_TYPE.put("血液和淋巴系统疾病", "55c761e75d84145c548a9a95");
        DRUG_TYPE.put("维生素与矿物质", "55c761e75d84145c548a9a96");*/
    }
}
