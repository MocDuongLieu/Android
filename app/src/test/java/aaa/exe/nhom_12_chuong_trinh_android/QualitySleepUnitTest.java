package aaa.exe.nhom_12_chuong_trinh_android;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import aaa.exe.nhom_12_chuong_trinh_android.main.activity.QualitySleepActivity;
import aaa.exe.nhom_12_chuong_trinh_android.main.dao.ProfileDAO;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 28)
public class QualitySleepUnitTest {

    @Mock
    ProfileDAO profileDAO;

    private QualitySleepActivity qualitySleepActivity;

    @Before
    public void setup() {
        // Khởi tạo mock object
        MockitoAnnotations.initMocks(this);

        // Khởi tạo QualitySleepActivity và inject mock ProfileDAO
        qualitySleepActivity = new QualitySleepActivity();
        qualitySleepActivity.profileDAO = profileDAO;
    }

    @Test
    public void testGetStatusFromAgeGroup_Children_EnoughSleep() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Trẻ em");

        String result = qualitySleepActivity.XacDinhTrangThaiTuNhomTuoi(11.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Đủ", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Youth_Sleepless() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Thanh niên");

        String result = qualitySleepActivity.XacDinhTrangThaiTuNhomTuoi(8.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Ngủ ít", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Teenager_SleepTooMuch() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Thanh thiếu niên");

        String result = qualitySleepActivity.XacDinhTrangThaiTuNhomTuoi(11.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Ngủ quá nhiều", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Adolescent_EnoughSleep() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Vị thành niên");

        String result = qualitySleepActivity.XacDinhTrangThaiTuNhomTuoi(8.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Đủ", result);
    }

    @Test
    public void testGetStatusFromAgeGroup_Seniors_Sleepless() {
        // Thiết lập các giá trị trả về của ProfileDAO
        when(profileDAO.getAgeGroup()).thenReturn("Người già");

        String result = qualitySleepActivity.XacDinhTrangThaiTuNhomTuoi(6.0f);

        // Kiểm tra kết quả trả về
        assertEquals("Ngủ ít", result);
    }

}
