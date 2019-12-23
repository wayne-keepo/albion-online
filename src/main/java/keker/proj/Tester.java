package keker.proj;

import org.jutils.jprocesses.JProcesses;
import org.jutils.jprocesses.model.ProcessInfo;

import java.io.IOException;
import java.util.*;

public class Tester {
    public static final String AO_PROC_NAME = "Albion-Online.exe";

    public static void main(String[] args) throws IOException, InterruptedException {
//        Connection nc = Nats.connect("nats://public:thenewalbiondata@www.albion-online-data.com:4222");
//        /*
//        goldprices.deduped
//        marketorders.deduped
//        mapdata.deduped
//        */
//        System.out.println(nc.getStatus());
//        Subscription sub = nc.subscribe("marketorders.deduped");
//
//        Message msg = sub.nextMessage(Duration.ofMillis(6000));
//        String response = new String(msg.getData(), StandardCharsets.UTF_8);
//        System.out.println(response);
//        Thread.sleep(60000);
            String s1 = "T4_CLOTH_LEVEL1@1";
            String s2 = "T4_CLOTH";

        System.out.println(Arrays.toString(s1.split("_")));
        System.out.println(Arrays.toString(s2.split("_")));
    }

    private void getAOProcess() {
        List<ProcessInfo> pl = JProcesses.getProcessList();
        Map<String, String> ao_proc = new HashMap<>();
        pl.forEach(pi -> {
            if (pi.getName().equalsIgnoreCase(AO_PROC_NAME)) {
                System.out.println(pi.getName() + " " + pi.getPid());
                ao_proc.put(AO_PROC_NAME, pi.getPid());
            }
        });
    }
}
