package usama.utech.newproject.CurrencyStuff;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tomm on 4/4/16 AD.
 */
public interface CurrencyExchangeService {
    @GET("latest?access_key=b9f5a14f77e6e7bfed8e7ef937dd690d")
    Call<CurrencyExchange> loadCurrencyExchange();
}
