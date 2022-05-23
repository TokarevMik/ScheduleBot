package com.tokarev.bot.entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TestBot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@MyScheduleStiks84Bot";
    }
    @Override
    public String getBotToken() {
        return "5348075973:AAEAQT2tLxiH0hlBDHNGD_JpreyaJ3U56pY";
    }
    public static void main(String[] args) throws TelegramApiException {
        TestBot testBot = new TestBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class); //поток для регистрации бота
        telegramBotsApi.registerBot(testBot); // регистрация бота

    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (message.hasText()) {
                try {
                    execute(
                            SendMessage.builder()
                                    .chatId(message.getChatId().toString())
                            .text("You send - \n\n" + message.getText())
                            .build());
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
