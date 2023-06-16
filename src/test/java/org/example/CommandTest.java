package org.example;
import com.google.gson.Gson;
import junit.framework.TestCase;

public class CommandTest extends TestCase {
    public void testFromJSONString() {
        String jsonStr = "{\"cmd\":\"list\"}";
        Gson g = new Gson();
        Command cmd = g.fromJson(jsonStr, Command.class);
        assertTrue(cmd.cmd.equals("list"));


        String jsonStr2 = "{\"cmdd\":\"list\"}";
        Command cmd2 = g.fromJson(jsonStr2, Command.class);
        assertTrue(cmd2.cmd == null);

        String jsonStr3 = "{\"cmd\":\"login\", \"param1\":\"john\", \"param2\":\"doe\"}";
        Command cmd3 = g.fromJson(jsonStr3, Command.class);
        assertTrue(cmd3.param2.equals("Doe"));
    }

}