package id.my.rizki.kuroyukibot.bot;
/*
    Created by : Rizki Maulana Akbar, On 02 - 2018 ;
*/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import oshi.SystemInfo;
import oshi.software.os.OperatingSystem;

import java.util.List;

@Component
public class KuroyukiInstance extends TelegramLongPollingBot {

    private static final Logger logger = LoggerFactory.getLogger(KuroyukiInstance.class);

    private String token = "532784572:AAHBANaai7lrDLrSeTlE4OhrvcnU3HGJX-E";

    private String username = "kuroyukichan_bot";

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println("Triggered");
        if (update.hasMessage()) {
            System.out.println("got a message");
            Message message = update.getMessage();
            SendMessage response = new SendMessage();
            Long chatId = message.getChatId();
            response.setChatId(chatId);
            String text = message.getText();
            response.setText("Currently Unavailable");
            try {
                sendMessage(response);
                logger.info("Sent message \"{}\" to {}", text, chatId);
            } catch (TelegramApiException e) {
                logger.error("Failed to send message \"{}\" to {} due to error: {}", text, chatId, e.getMessage());
            }
        }
    }

}
