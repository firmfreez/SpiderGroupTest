package com.firmfreez.android.spidergrouptest.exceptions

import okhttp3.Response

class WrongResponseCodeException(message: String, displayedMessage: String? = null, response: Response? = null): NetworkResponseException(message, displayedMessage, response)