package nyc.c4q.artsy4android.splashpage;

import io.reactivex.Single;
import nyc.c4q.artsy4android.models.Token;
import nyc.c4q.artsy4android.network.RetrofitService;

class SplashTokenRepository {
    private RetrofitService retrofitService;

    SplashTokenRepository(RetrofitService retrofitService){
        this.retrofitService = retrofitService;
    }

    Single<Token> createToken(String client_id, String client_secret) {
        return retrofitService.createToken(client_id, client_secret);
    }
}