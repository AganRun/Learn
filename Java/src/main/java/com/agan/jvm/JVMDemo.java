package com.agan.jvm;

import java.lang.management.*;
import java.util.Arrays;
import java.util.List;


public class JVMDemo {

    public static void main(String[] args) {

        System.out.println("----------Memory--------");
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage usage = memoryMXBean.getHeapMemoryUsage();
        System.out.println("初始化Heap：" + usage.getInit()/1024/1024 + "mb");
        System.out.println("最大Heap：" + usage.getMax()/1024/1024 + "mb");
        System.out.println("已使用Heap：" + usage.getUsed()/1024/1024 + "mb");
        System.out.println("Heap Memory Usage：" + memoryMXBean.getHeapMemoryUsage());
        System.out.println("Non-Heap Memory Usage: " + memoryMXBean.getNonHeapMemoryUsage());
        /*
         * 结果为：
         * 初始化Heap：254mb
         * 最大Heap：3604mb
         * 已使用Heap：5mb
         * Heap Memory Usage：init = 266338304(260096K) used = 5326968(5202K) committed = 255328256(249344K) max = 3779067904(3690496K)
         * Non-Heap Memory Usage: init = 2555904(2496K) used = 4886200(4771K) committed = 8060928(7872K) max = -1(-1K)
         */

        System.out.println("-----------Runtime----------");
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println("JVM name: " + runtimeMXBean.getVmName());
        System.out.println("Lib path: " + runtimeMXBean.getLibraryPath());
        System.out.println("Class path: " + runtimeMXBean.getClassPath());
        System.out.println("VM Version: " + runtimeMXBean.getVmVersion());
        /*
         * JVM name: Java HotSpot(TM) 64-Bit Server VM
         * Lib path: C:\Program Files\Java\jdk1.8.0_202\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Windows\System32\OpenSSH\;C:\Program Files\NVIDIA Corporation\NVIDIA NvDLISR;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Program Files\Java\jdk1.8.0_202\bin;C:\Users\agan\Desktop\heiheihie;C:\Program Files\Git\cmd;C:\Users\agan\AppData\Local\Microsoft\WindowsApps;;.
         * Class path: C:\Program Files\Java\jdk1.8.0_202\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\deploy.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\access-bridge-64.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\cldrdata.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\dnsns.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\jaccess.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\jfxrt.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\localedata.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\nashorn.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\sunec.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\sunjce_provider.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\sunmscapi.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\sunpkcs11.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\ext\zipfs.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\javaws.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\jfxswt.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\management-agent.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\plugin.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_202\jre\lib\rt.jar;D:\Work\Code\Learn\Java\target\classes;D:\Work\JAVA\MavenRepo\junit\junit\4.12\junit-4.12.jar;D:\Work\JAVA\MavenRepo\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\Work\JAVA\MavenRepo\org\projectlombok\lombok\1.16.20\lombok-1.16.20.jar;D:\Work\JAVA\MavenRepo\org\slf4j\slf4j-api\1.7.28\slf4j-api-1.7.28.jar;D:\Work\JAVA\MavenRepo\ch\qos\logback\logback-classic\1.2.3\logback-classic-1.2.3.jar;D:\Work\JAVA\MavenRepo\ch\qos\logback\logback-core\1.2.3\logback-core-1.2.3.jar;D:\Work\Program\IntelliJ IDEA 2018.3.6\lib\idea_rt.jar;C:\Users\agan\.IntelliJIdea2018.3\system\captureAgent\debugger-agent.jar
         * VM Version: 25.202-b08
         */

        System.out.println("-----------OperatingSystem----------");
        OperatingSystemMXBean osMBean = ManagementFactory.getOperatingSystemMXBean();
        //获取操作系统相关信息
        System.out.println("SystemName: " + osMBean.getName());
        System.out.println("SystemVersion: " + osMBean.getVersion());
        System.out.println("System可用处理器数 " + osMBean.getAvailableProcessors());
        /*
         * SystemName: Windows 10
         * SystemVersion: 10.0
         * System可用处理器数 8(本人电脑四核八线程，逻辑数)
         */

        System.out.println("-----------Thread----------");
        //获取各个线程的各种状态，CPU 占用情况，以及整个系统中的线程状况
        ThreadMXBean threadMBean = ManagementFactory.getThreadMXBean();
        System.out.println("线程总数 " + threadMBean.getThreadCount());
        System.out.println("峰值线程数 " + threadMBean.getPeakThreadCount());
        System.out.println("当前线程CPU时间 " + threadMBean.getCurrentThreadCpuTime());
        System.out.println("守护线程数 " + threadMBean.getDaemonThreadCount());
        System.out.println("当前线程已执行的CPU时间 "+ threadMBean.getCurrentThreadUserTime());
        /*
         * 线程总数		     5
         * 峰值线程数    	 5
         * 当前线程CPU时间	 218750000
         * 守护线程数		 4
         * 当前线程已执行的CPU时间	 125000000
         */

        System.out.println("-----------MemoryPool----------");
        List<MemoryPoolMXBean> mpMBeanList= ManagementFactory.getMemoryPoolMXBeans();
        mpMBeanList.forEach(mpBean ->{
            System.out.println("使用状况 " + mpBean.getUsage());
            System.out.println("内存管理器名称 "+ Arrays.toString(mpBean.getMemoryManagerNames()));
        });
        /*
         * 使用状况 init = 2555904(2496K) used = 1550080(1513K) committed = 2555904(2496K) max = 251658240(245760K)
         * 内存管理器名称 [CodeCacheManager]
         * 使用状况 init = 0(0K) used = 4910120(4795K) committed = 5373952(5248K) max = -1(-1K)
         * 内存管理器名称 [Metaspace Manager]
         * 使用状况 init = 0(0K) used = 551696(538K) committed = 655360(640K) max = 1073741824(1048576K)
         * 内存管理器名称 [Metaspace Manager]
         * 使用状况 init = 66584576(65024K) used = 9367904(9148K) committed = 66584576(65024K) max = 1394606080(1361920K)
         * 内存管理器名称 [PS MarkSweep, PS Scavenge]
         * 使用状况 init = 11010048(10752K) used = 0(0K) committed = 11010048(10752K) max = 11010048(10752K)
         * 内存管理器名称 [PS MarkSweep, PS Scavenge]
         * 使用状况 init = 177733632(173568K) used = 0(0K) committed = 177733632(173568K) max = 2834300928(2767872K)
         * 内存管理器名称 [PS MarkSweep]
         */

        System.out.println("-----------GarbageCollector----------");
        List<GarbageCollectorMXBean> gcMBeanList = ManagementFactory.getGarbageCollectorMXBeans();
        gcMBeanList.forEach(gcBean -> {
            System.out.println("名称 " + gcBean.getName());
            System.out.println("内存池名称() "+ Arrays.toString(gcBean.getMemoryPoolNames()));
        });
        /*
         * 名称 PS Scavenge
         * 内存池名称() [PS Eden Space, PS Survivor Space]
         * 名称 PS MarkSweep
         * 内存池名称() [PS Eden Space, PS Survivor Space, PS Old Gen]
         */

        System.out.println("-----------other----------");
        int total = (int)Runtime.getRuntime().totalMemory()/1024/1024;
        System.out.println("内存总量 ：" + total + "mb");
        int free = (int)Runtime.getRuntime().freeMemory()/1024/1024;
        System.out.println("空闲内存量 ： " + free + "mb");
        int max = (int) (Runtime.getRuntime().maxMemory() /1024 / 1024);
        System.out.println("最大内存量Xmx ： "  + max + "mb");
        /*
         * 内存总量 ：243mb
         * 空闲内存量 ： 234mb
         * 最大内存量Xmx ： 3604mb
         */
    }

}
