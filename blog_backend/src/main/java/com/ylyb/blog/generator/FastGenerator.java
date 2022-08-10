package com.ylyb.blog.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;

import java.util.Arrays;
import java.util.List;

public class FastGenerator {
    private String url = "jdbc:mysql://localhost:3306/ylyb_blog?useSSL=false&useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
    private List<String> table = Arrays.asList("drafts");
    public void fastGenerate(){
        FastAutoGenerator.create(url, "root", "root")
                .globalConfig(builder -> builder.outputDir("C:\\Users\\Tiger\\eclipse-workspace\\YLYB-Blog-backend\\blog_backend\\src\\main\\java"))
                .strategyConfig(builder -> builder.addInclude(table))
                .packageConfig(builder -> builder.parent("com.ylyb.blog"))
                .execute();
    }

    public static void main(String[] args) {
        new FastGenerator(). fastGenerate();
    }

}
