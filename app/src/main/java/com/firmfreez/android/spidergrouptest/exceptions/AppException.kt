package com.firmfreez.android.spidergrouptest.exceptions

import com.firmfreez.android.spidergrouptest.utils.AppContext

/**
 * Общий класс исключений для приложения
 *
 * @param message - стандартный для Exception
 * @param displayedMessage - сообщение, которое можно вывести пользователю
 *
 * **/
open class AppException(message: String, override val displayedMessage: String? = null): Exception(message), DisplayedMessageExceptionInterface {
    constructor(message: String, displayedMessage: Int? = null): this(message, AppContext.getString(displayedMessage))
}