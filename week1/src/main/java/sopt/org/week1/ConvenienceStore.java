package sopt.org.week1;

public class ConvenienceStore {
    private String brand;
    private String address;
    private int staffCount;
    private int visitorCount;

    // 생성자 생성
    public ConvenienceStore(String brand, String address, int staffCount, int visitorCount) {
        this.brand = brand;
        this.address = address;
        this.staffCount = staffCount;
        this.visitorCount = visitorCount;
    }

    public void addStaffCount() {
        staffCount++;
    }

    public void addVisitorCOunt() {
        visitorCount++;
    }

    public void initVisitorCount() {
        visitorCount = 0;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void printConvenienceStoreInfo() {
        System.out.println("편의점 브랜드 = " + brand);
        System.out.println("편의점 주소 = " + address);
        System.out.println("편의점 직원 수 = " + staffCount);
        System.out.println("편의점 방문자 수 = " + visitorCount);
    }
}
