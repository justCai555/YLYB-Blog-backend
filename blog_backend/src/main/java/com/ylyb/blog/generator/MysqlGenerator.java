package com.ylyb.blog.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

import java.util.Collections;

public class MysqlGenerator{
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/ylyb_blog?serverTimezone=Asia/Shanghai","root", "root")
            .schema("ylyb_blog")
            .build();

    public void testSimple(){
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                .outputDir("/opt/blog_backend")
                .author("YLYB")
                .enableKotlin()
                .enableSwagger()
                .dateType(DateType.TIME_PACK)
                .commentDate("yyyy-MM-dd")
                .build();
//        PackageConfig packageConfig = new PackageConfig.Builder()
//                .parent("com.ylyb.blog")
//                .moduleName("sys")
//                .entity("entity")
//                .service("service")
//                .serviceImpl("service.impl")
//                .mapper("mapper")
//                .xml("mapper.xml")
//                .controller("controller")
//                .pathInfo(Collections.singletonMap(OutputFile.xml, "D://")
//                        .build();
        generator.strategy(generator.getStrategy());
        generator.global(globalConfig);
        generator.execute();
    }

    public static void main(String[] args) {
        new MysqlGenerator().testSimple();
    }
}
