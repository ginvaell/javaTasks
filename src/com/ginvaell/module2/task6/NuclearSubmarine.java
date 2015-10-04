package com.ginvaell.module2.task6;

@ClassInfo(
        author = "Ginvaell",
        date = "4/10/15"
)
public class NuclearSubmarine {
    private final Engine engine = new Engine();
    private boolean moving;

    public void start() {
        engine.start();
    }

    public void sail() {
        if (engine.isWorking()) moving = true;
    }

    public String getInfo() {
        String result = "Engine ";
        if (engine.isWorking()) result += "is working\n";
        else result += "does not work\n";
        result += "Submarine ";
        if (moving) result += "is moving";
        else result += "does not move";
        return result;
    }

    private class Engine {

        private boolean working;

        public void start() {
            working = true;
        }

        public void stop() {
            working = false;
        }

        public boolean isWorking() {
            return working;
        }
    }
}
