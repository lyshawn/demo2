package com.example.a9splay_user.demo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.niceplay.auth.util.NPGameLog;
import com.niceplay.authclient_three.NPCallBackKeys;
import com.niceplay.authclient_three.NPPlayGameKeys;
import com.niceplay.authclient_three.NPPlayGameSDK;

public class MainActivity extends AppCompatActivity {

    private String appid = "DEMO";
    private String GameUID = "";
    private String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NPGameLog.setDebugMode(false);
        NPPlayGameSDK npPlayGameSDK = NPPlayGameSDK.getInstance();
        npPlayGameSDK.setPlayGameServiceListener(new NPPlayGameSDK.onNPServiceListener() {

            @Override
            public void event(String Name, int code, String message, Bundle b) {

                switch (NPCallBackKeys.valueOf(code)) {

                    //網路連接失敗
                    case NetworkError:

                        break;

                    //玩家拒絕權限
                    case PermissionsDenied:
                        break;

                    //9S登入成功
                    case NPSignInSuccess:

                         GameUID = b.getString(NPPlayGameKeys.NPGameUid.toString());

                         token = b.getString(NPPlayGameKeys.TOKEN.toString());

                        boolean isGooglePlayBinding = b.getBoolean(NPPlayGameKeys.IsGooglePlayBinding.toString());

                        break;

                    //GooglePlay登入成功
                    case GooglePlaySignInSuccess:

                        String icon = b.getString(NPPlayGameKeys.ICONIMAGEURL.toString());

                        String name = b.getString(NPPlayGameKeys.DISPLAYNAME.toString());

                        break;

                    //切換帳號成功
                    case SwitchAccountSuccess:

                         GameUID = b.getString(NPPlayGameKeys.NPGameUid.toString());

                         token = b.getString(NPPlayGameKeys.TOKEN.toString());

                         isGooglePlayBinding = b.getBoolean(NPPlayGameKeys.IsGooglePlayBinding.toString());

                        break;

                    //切換帳號失敗
                    case SwitchAccountError:

                        break;

                    //帳號轉移成功
                    case AccountTransferSuccess:

                         GameUID = b.getString(NPPlayGameKeys.NPGameUid.toString());

                         token = b.getString(NPPlayGameKeys.TOKEN.toString());

                         isGooglePlayBinding = b.getBoolean(NPPlayGameKeys.IsGooglePlayBinding.toString());

                        break;

                    //綁定成功
                    case BindindSuccess:

                         GameUID = b.getString(NPPlayGameKeys.NPGameUid.toString());

                         token = b.getString(NPPlayGameKeys.TOKEN.toString());

                         isGooglePlayBinding = b.getBoolean(NPPlayGameKeys.IsGooglePlayBinding.toString());

                        break;
                    default:
                        break;
                }
            }
        });
        npPlayGameSDK.setLoginRequestCode(888);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        NPPlayGameSDK.getInstance().onActivityResult(requestCode, resultCode, data);
    }
}
