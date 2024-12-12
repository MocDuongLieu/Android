package aaa.exe.nhom_12_chuong_trinh_android;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;

import aaa.exe.nhom_12_chuong_trinh_android.main.activity.BMIIndexActivity;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE, sdk = 28)
public class BmiIndexUnitTest {

    @Test
    public void testGetStatus_NoUnderlyingDiseases_Youth_NormalBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>();
        float height = 1.6f;
        float weight = 50f;
        String ageGroup = "Thanh niên";

        String expected = "Malnutrition";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStatus_Diabetes_MiddleAge_OverweightBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Tiểu đường"));
        float height = 1.7f;
        float weight = 85f;
        String ageGroup = "Trung niên";

        String expected = "Bình thường";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStatus_HighBloodPressure_Adolescent_UnderweightBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Huyết áp cao"));
        float height = 1.75f;
        float weight = 60f;
        String ageGroup = "Vị thành niên";

        String expected = "Bình thường";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStatus_Fatigue_Children_MalnutritionBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Mệt mỏi"));
        float height = 1.0f;
        float weight = 10f;
        String ageGroup = "Trẻ em";

        String expected = "Suy dinh dưỡng";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetStatus_MentalIllness_Old_FatBMI() {
        BMIIndexActivity activity = mock(BMIIndexActivity.class);
        ArrayList<String> diseases = new ArrayList<>(Arrays.asList("Rối loạn tâm thần"));
        float height = 1.5f;
        float weight = 100f;
        String ageGroup = "Người già";

        String expected = "Béo";
        when(activity.getStatus(diseases, height, weight, ageGroup)).thenCallRealMethod();
        String actual = activity.getStatus(diseases, height, weight, ageGroup);

        assertEquals(expected, actual);
    }

}
