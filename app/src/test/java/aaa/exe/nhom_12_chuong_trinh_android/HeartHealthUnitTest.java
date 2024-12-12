package aaa.exe.nhom_12_chuong_trinh_android;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;

import aaa.exe.nhom_12_chuong_trinh_android.main.activity.HeartHealthActivity;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 28)
public class HeartHealthUnitTest {

    private HeartHealthActivity heartHealthActivity;

    @Before
    public void setup() {
        // Khởi tạo mock object
        MockitoAnnotations.initMocks(this);

        // Khởi tạo HeartHealthActivity và inject mock ProfileDAO
        heartHealthActivity = new HeartHealthActivity();
    }

    @Test
    public void testGetStatus_Children_Male_NoDiseases_Normal() {
        ArrayList<String> diseases = new ArrayList<>();
        String result = heartHealthActivity.getStatus(diseases, 75.0f, 100.0f, "Trẻ em");

        // Kiểm tra kết quả trả về
        assertEquals("Normal", result);
    }

    @Test
    public void testGetStatus_Teenager_Female_Diabetes_High() {
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Tiểu đường"));
        String result = heartHealthActivity.getStatus(diseases, 100.0f, 140.0f, "Thanh thiếu niên");

        // Kiểm tra kết quả trả về
        assertEquals("Cao", result);
    }

    @Test
    public void testGetStatus_Adolescent_Male_HighBloodPressure_Low() {
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Huyết áp cao"));
        String result = heartHealthActivity.getStatus(diseases, 50.0f, 70.0f, "Vị thành niên");

        // Kiểm tra kết quả trả về
        assertEquals("Thấp", result);
    }

    @Test
    public void testGetStatus_MiddleAge_Female_MentalIllness_Normal() {
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Rối loạn tâm thần"));
        String result = heartHealthActivity.getStatus(diseases, 70.0f, 90.0f, "Trung niên");

        // Kiểm tra kết quả trả về
        assertEquals("Bình thường", result);
    }

    @Test
    public void testGetStatus_Old_Male_NoDiseases_Hypertension() {
        ArrayList<String> diseases = new ArrayList<>();
        String result = heartHealthActivity.getStatus(diseases, 100.0f, 150.0f, "Người già");

        // Kiểm tra kết quả trả về
        assertEquals("Cao", result);
    }

}
