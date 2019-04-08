import { NativeModules,ToastAndroid } from 'react-native';
const NOTIF = NativeModules.RNHsnzNotificaton;



export default class Notification {
    constructor(tag,id,directory,fileName){
        const OPEN_APP = true;
        const NOT_OPEN_APP = false;
        const DISMISS_NOTIFICATION = true;
        const KEPP_NOTIFICATION = false;
        NOTIF.init(tag,id,directory,fileName);
    }
    async
    show(){
        NOTIF.show();
    }
    dismiss(){
        NOTIF.dismiss();
    }
    addAction(directory,fileName,title,open,dismiss,reactFunc){
        NOTIF.addAction(directory,fileName,title,open,dismiss,reactFunc);
    }
    cancelByTouch(cancel){
        NOTIF.cancelByTouch(cancel);
    }
    setBadgeIcon(directory,fileName){
        NOTIF.setBadgeIcon(directory,fileName);
    }
    setColor(red,green,blue){
        color = 256*256*red+256*green+blue;
        NOTIF.setColor(color)
    }
    setContentInfo(info){
        NOTIF.setContentInfo(info);
    }
    setContentText(text){
        NOTIF.setContentText(text);
    }
    setContentTitle(title){
        NOTIF.setContentTitle(title);
    }
    setNumber(number){
        NOTIF.setNumber(number);
    }
    setLights(red,green,blue,onMS,offMS){
        color = 256*256*red+256*green+blue;
        NOTIF.setLights(color,onMS,offMS);
    }
    setVibrate(pattenr){
        NOTIF.setVibrate(pattenr);
    }
}
