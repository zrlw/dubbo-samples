/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.demo.DemoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @DubboReference(group = "normal")
    DemoService demoServiceFromNormal;

    @DubboReference(group = "dual")
    DemoService demoServiceFromDual;

    @DubboReference(group = "service")
    DemoService demoServiceFromService;


    @Override
    public void run(String... args) {
        System.out.println("demoServiceFromDual response ===>  "+demoServiceFromDual.sayHello("123"));
        System.out.println("demoServiceFromService response ===> " +demoServiceFromService.sayHello("456"));
        System.out.println("demoServiceFromNormal response ===> "+demoServiceFromNormal.sayHello("000"));
    }

}
