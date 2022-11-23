package com.mad.real_estate_app.util

import java.time.LocalDate

data class TextFieldParams(
    val hint: String,
    val maxLength: Int = 100,
    val type: String? = null,
    val helperText: String? = null,
    val minLength: Int = 0,
    val initialValue: String = "",
    val required: Boolean = false,
)

data class DialogConfirmParams(
    val title: CharSequence,
    val subtitle: CharSequence? = null,
    val yesButtonTex: CharSequence = "Ok",
    val noButtonTex: CharSequence = "Cancel",
)

data class LoanDialogConfirmParams(
    val title: CharSequence,
    val subtitle: CharSequence? = null,
    val yesButtonTex: CharSequence = "Accept",
    val noButtonTex: CharSequence = "Decline",
)

data class DateInputParams(
    val title: String,
    val maxDate: LocalDate? = null,
    val minDate: LocalDate? = null,
)

data class DialogOptionItem(
    val title: String,
    val subtitle: String? = null,
    val extraInfo: String? = null,
)
