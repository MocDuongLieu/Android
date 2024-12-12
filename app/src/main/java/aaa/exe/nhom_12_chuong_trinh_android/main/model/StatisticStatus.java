package aaa.exe.nhom_12_chuong_trinh_android.main.model;

public class StatisticStatus {
    private String status;
    private Float percent;

    public StatisticStatus() {
    }

    public StatisticStatus(String status, Float percent) {
        this.status = status;
        this.percent = percent;
    }

    public String getStatus() {
        return status;
    }

    public Float getPercent() {
        return percent;
    }

}
