package gif.ganesh.pushnotififirebase.retrofitWorking.helpers;

import gif.ganesh.pushnotififirebase.retrofitWorking.response.AttendenceLIstResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices
{

    @FormUrlEncoded
    @POST("Attendencelist")
    Call<AttendenceLIstResponse> AttendenceList(@Field("institution_id") int institution_id,
                                                @Field("academic_id") int academic_id,
                                                @Field("class_id") int class_id);
}
