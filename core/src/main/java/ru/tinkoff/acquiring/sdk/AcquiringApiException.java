/*
 * Copyright © 2016 Tinkoff Bank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.tinkoff.acquiring.sdk;

import ru.tinkoff.acquiring.sdk.responses.AcquiringResponse;

/**
 * Исключение выбрасываемое методами AcquiringSdk, в случае если сервер ответил ошибкой
 *
 * @author a.shishkin1
 */
public class AcquiringApiException extends Exception {

    private AcquiringResponse response;

    public AcquiringApiException(String message, AcquiringResponse response, Throwable cause) {
        super(message, cause);
        this.response = response;
    }

    public AcquiringApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public AcquiringApiException(AcquiringResponse response, String message) {
        super(message);
        this.response = response;
    }

    public AcquiringApiException(AcquiringResponse response) {
        super("");
        this.response = response;
    }

    public AcquiringResponse getResponse() {
        return response;
    }
}
