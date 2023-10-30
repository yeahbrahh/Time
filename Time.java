public class Time {

    private int sec;
    private int min;
    private int hour;

    // Default time class constructor
    public Time() {
        this.hour = 0;
        this.min = 0;
        this.sec = 0;

    }

    public Time(int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }


    public static Time fromString(String timeString) {

        String[] parts = timeString.split(":");
        int hours = Integer.parseInt(parts[0]);
        int min = Integer.parseInt(parts[1]);
        int sec = Integer.parseInt(parts[2]);

        return new Time(hours, min, sec);


    }

    public void increment(int sec) {
        this.sec += sec;

        while (this.sec >= 60) {
            this.sec -= 60;
            this.min++;

            if (this.min >= 60) {
                this.min -= 60;
                this.hour++;

                if (this.hour >= 24) {
                    this.hour -= 24;
                }

            }
        }
    }

    public void print(boolean military) {
        String format = military ? "%02d:%02d:%02d" : "%d:%02d:%02d %s";
        if (military) {
            System.out.printf(format + "\n", this.hour, this.min, this.sec);
        } else {
            String period = this.hour < 12 ? "AM" : "PM";
            int hours12 = this.hour % 12 == 0 ? 12 : this.hour % 12;
            System.out.printf(format + "\n", hours12, this.min, this.sec, period);
        }
    }
}




