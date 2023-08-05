package com.agan.classload.reload;

import java.util.Scanner;

public class ReloadableApplication {

    /**
     * Service类型的全局变量
     */
    private static Service service;

    /**
     * 加载指定目录中的 Service
     */
    private static void loadService() throws Exception {
        // 首先创建一个全新的 ClassLoader 对象。因为new了，所以是一个全新的对象。里面也没有原有缓存类
        ClassLoader myLoader = new MyCommonClassLoader("D:\\Java\\Code\\Learn\\Java\\target\\classes");
        // 调用 Class.forName 加载指定的 Service 类
        Class<?> serviceCls = Class.forName(
                "com.agan.classload.reload.Service",
                false,
                myLoader);

        if (service != null) {
            service.stop();
        }

        // 创建 Service 对象，然后运行它
        service = (Service) serviceCls.newInstance();
        service.start();
    }

    public static void main(String[] args) throws Exception {
        loadService();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if ("reload".equalsIgnoreCase(command)) {
                // 重新加载服务
                // 在不停止当前进程的前提下，加载最新版本的类
                loadService();
            } else if ("exit".equalsIgnoreCase(command)) {
                // 停止服务
                if (service != null) {
                    service.stop();
                }
                break;
            } else {
                System.out.println(command);
            }
        }
    }
}
