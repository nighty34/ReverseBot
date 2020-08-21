package ch.nightfury34.reversebot;


import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.managers.AudioManager;

public class ChannelManager {
    private static ChannelManager instance;
    private TextChannel textChannel;
    private VoiceChannel voiceChannel;
    private AudioManager audioManager;

    public ChannelManager(){

    }


    public static ChannelManager getInstance(){
        if(instance == null){
            instance = new ChannelManager();
        }
        return instance;

    }


    public TextChannel getTextChannel() {
        return textChannel;
    }

    public void setTextChannel(TextChannel textChannel) {
        this.textChannel = textChannel;
    }

    public VoiceChannel getVoiceChannel() {
        return voiceChannel;
    }

    public void setVoiceChannel(VoiceChannel voiceChannel) {
        if(voiceChannel != null) {
            this.voiceChannel = voiceChannel;
        }else{
            this.voiceChannel = null;
        }
    }
}
