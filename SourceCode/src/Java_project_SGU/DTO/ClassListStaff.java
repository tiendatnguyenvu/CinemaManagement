package Java_project_SGU.DTO;

import Java_project_SGU.Controller.StaffControllerImp;
import Java_project_SGU.DAL.DAL_Implement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class ClassListStaff {
    private List<Staff> staffs;
    private StaffControllerImp staffControllerImp;

    // constrcutor
    public ClassListStaff() {
        this.staffs = new ArrayList<>();
        this.staffControllerImp = new StaffControllerImp();
    }
    
    public ClassListStaff(List<Staff> listStaff) {
        this.staffs = listStaff;
        this.staffControllerImp = new StaffControllerImp();
    }

    // getter and setter
    public List<Staff> getListStaff() {
        return staffs;
    }

    public void setListStaff(List<Staff> listStaff) {
        this.staffs = listStaff;
    }
    
    // hàm phương thức
    // thêm nhân viên
    public void addStaff(Staff staff) {
        this.staffs.add(staff);
    }
    
    // xóa nhân viên
    public void removeStaff(String ID_StaffNeedDelete) {
        for (Staff x : staffs){
            if (x.getID_Staff().equals(ID_StaffNeedDelete)){
                this.staffs.remove(x);
                break;
            }
        }
    }
    
    // sửa nhân viên
    public void updateStaff() {
    }
    
    // sắp xếp nhân viên theo tên từ a-z
    public void sortStaffNameASC() {
        this.staffControllerImp.sortStaffByNameASC(this.staffs);
    }
    
    // sắp xếp nhân viên theo tên từ z-a
    public void sortStaffNameDESC() {
        this.staffControllerImp.sortStaffByNameDESC(this.staffs);
    }
    
    // sắp xếp nhân viên theo ngày gần nhất
    public void sortStaffStartDateNear() {
        this.staffControllerImp.sortStaffByStartDateASC(this.staffs);
    }
    
    // sắp xếp nhân viên theo ngày xa nhất
    public void sortStaffStartDateFar() {
        this.staffControllerImp.sortStaffByStartDateDESC(this.staffs);
    }
    
    // tìm kiếm nhân viên theo tên
    public List<Staff> searchStatffByName(String fullName) {
        List<Staff> staffsFound = new ArrayList<>();
        String regex = "^.*" + fullName + ".*$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        for (Staff x : staffs) {
            if (pattern.matcher(x.getFullName()).matches()) {
                staffsFound.add(x);
            }
        }
        return staffsFound;
    }
    
    // tìm kiếm nhân viên theo ngày đăng kí 
    public List<Staff> searchStaffByStartDate(String startDate) throws ParseException {
        List<Staff> staffsFound = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateParse = dateFormat.parse(startDate);
        for (Staff x : staffs) {
            if (x.getStartDate().equals(dateParse)) {
                staffsFound.add(x);
            }
        }   
        return staffsFound;
    }

    // tìm kiếm nhân viên theo số điện thoại
    public List<Staff> searchStaffByPhoneNumber(String phoneNumber) {
        List<Staff> staffsFound = new ArrayList<>();
        for (Staff x : staffs){
            if(x.getPhoneNumber().equals(phoneNumber)) {
                staffsFound.add(x);
            }
        }
        return staffsFound;
    }
    
    // load những dữ liệu cần thiết để thống kê lương của nhân viên
    public void loadInfoStaff() {
        DAL_Implement readStaffSqlImp = new DAL_Implement();
        this.setListStaff(readStaffSqlImp.readStaffFromDataSource());
    }
}
