package com.taskagile.web.socket;

public class ChannelHandlers {

    public static String getPattern(ChannelHandler channelHandler) {
        if (!"".equals(channelHandler.pattern())) {
            return channelHandler.pattern();
        }
        return channelHandler.value();
    }

}
