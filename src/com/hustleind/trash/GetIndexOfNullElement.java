package com.hustleind.trash;

/**
 * Ищет в переданном массиве строки, начинающиеся с "null" и возвращает индексы элементов
 */

public class GetIndexOfNullElement {
    public static void main(String[] args) {
        String[] OSA = new String[]{"EXTERNAL_ID",
                "TRANS_ID_1",
                "TRANS_ID_2",
                "DATE_TIME",
                "SUBSCRIBER_TYPE",
                "MESSAGE_TYPE",
                "SUB_ID2",
                "REFUND_FLAG",
                "Null",
                "Null",
                "GROUP_ACCOUNT_TYPE",
                "Null ",
                "APPLICATION_ID",
                "SUBTYPE_ID",
                "UNIT_TYPE_ID",
                "TYPE_OF_CHARGE",
                "USAGE_AMOUNT",
                "Null",
                "Null",
                "CHARGE_CODE",
                "CONTENT_TYPE",
                "SERVICE_CODE",
                "ORP_DATE",
                "FUND_USAGE_TYPE",
                "SUBSCRIBER_CURRENCY",
                "CURR_CONV_RATE",
                "REQUESTED_ISO_CODE",
                "MSC_ID",
                "CIRCLE_ID",
                "MOG_ID",
                "BAL_INFO",
                "ACCU_INFO",
                "Null",
                "EXT_FIELD",
                "GROUP_ACCOUNT_INFO",
                "Null",
                "ORP_DATE",
                "Null",
                "RECORD_SOURCE",
                "ACCT_BAL_INFO",
                "ACCT_ACCU_INFO",
                "LIABILITY_REDIRECT_INDICATOR",
                "USER_SUBSCR_NO",
                "USER_SUBSCR_NO_RESETS",
                "TARGET_SUBSCR_NO",
                "TARGET_SUBSCR_NO_RESETS",
                "SUBSCR_NO",
                "SUBSCR_NO_RESETS ",
                "ACCOUNT_NO ",
                "INITIAL_AUT_ID",
                "FINAL_AUT_ID",
                "PARENT_ACCOUNT_NO",
                "SPLIT_ROW_NUM",
                "MSG_ID2",
                "MSG_ID ",
                "SLU_ID",
                "RESELLER_ID",
                "EXTERNAL_ID_TYPE",
                "PREV_ISO_CODE",
                "GSM_PROVIDER_ID ",
                "PRE_CHARGE",
                "MARKUP_PERCENT",
                "CONV_RATE_TO_BILLED_ACCT ",
                "BILLED_ACCOUNT_CURRENCY",
                "BILLED_ACCOUNT_TML_CHANGE",
                "BILLED_ACCOUNT_TML_VALUE ",
                "TIMEZONE",
                "ROUNDED_DURATION",
                "DATE_TIME_SUB_TZ ",
                "TARIFF_PLAN_ID ",
                "ORIG_TARIFF_PLAN_ID",
                "USAGE_OFFER_ID "
        };

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < OSA.length; i++) {
            if (OSA[i].length() >= 4  && OSA[i].substring(0,4).equalsIgnoreCase("null")) {
                sb.append(i).append(", ");
            }
        }
        if (sb.length()!=0) {
            System.out.println(sb.subSequence(0, sb.length() - 2).toString());
        }
    }
}
