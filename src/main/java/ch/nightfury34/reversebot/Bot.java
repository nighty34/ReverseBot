package ch.nightfury34.reversebot;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.List;


public class Bot extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
        new JDABuilder("TOKEN")
                .addEventListeners(new Bot())
                //s.setActivity(Activity.playing(""))
                .build();
    }

    private Member user;
    private VoiceChannel vc;

    private Bot() {
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        vc = event.getGuild().getVoiceChannelById("691587217600020510");
        String[] command = event.getMessage().getContentRaw().split(" ");
        //this.voiceChannel = event.getMessage().getMember().getVoiceState().getChannel();
        ChannelManager.getInstance().setTextChannel(event.getChannel());
        ChannelManager.getInstance().setVoiceChannel(event.getMember().getVoiceState().getChannel());

        if(event.getMessage().getAuthor().getAsTag().equals("diamon#9769") || event.getMessage().getAuthor().getAsTag().equals("nightfury34#2290") || event.getMessage().getAuthor().getAsTag().equals("Anaya#6319")){
            String message = reverseMessage(event.getMessage().getContentRaw());
            event.getMessage().getTextChannel().sendMessage(message).queue();
        }else if(event.getMessage().getContentRaw().startsWith("stfu")){

            this.user = event.getGuild().getMemberById(event.getMessage().getMentionedMembers().get(0).getIdLong());
            System.out.println("hi");
        }
        /*
        try {
            System.out.println(user);
            event.getGuild().moveVoiceMember(user, vc).queue();
        }catch (Exception e){
            e.printStackTrace();
        }*/

        System.out.println();
        super.onGuildMessageReceived(event);
    }

    private void printMessage(TextChannel channel, String message){
        channel.sendMessage(message).queue();
    }

    private static String reverseMessage(String message){
        byte[] strAsByteArray = message.getBytes();
        byte[] result = new byte[strAsByteArray.length];

        for (int i = 0; i< strAsByteArray.length; i++){
            result[i] = strAsByteArray[strAsByteArray.length-i-1];
        }
        return new String(result);
    }

    private void clearMessages(TextChannel channel, int amount){
        if (amount <= 100 && amount >= 1) {
            List<Message> messageList = channel.getHistory().retrievePast(amount).complete();
            /*if(channel.deleteMessages(messageList).queue()){

            }*/

        }else{
            channel.sendMessage("Amount has to be between 1 and 100").queue();
        }
    }

}