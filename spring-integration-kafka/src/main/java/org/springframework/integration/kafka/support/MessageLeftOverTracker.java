/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.kafka.support;

import kafka.message.MessageAndMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Soby Chacko
 * @since 0.5
 */
public class MessageLeftOverTracker {
	private final List<MessageAndMetadata> messageLeftOverFromPreviousPoll = new ArrayList<MessageAndMetadata>();

	public void addMessageAndMetadata(final MessageAndMetadata messageAndMetadata){
		messageLeftOverFromPreviousPoll.add(messageAndMetadata);
	}

	public List<MessageAndMetadata> getMessageLeftOverFromPreviousPoll(){
		return messageLeftOverFromPreviousPoll;
	}

	public void clearMessagesLeftOver(){
		messageLeftOverFromPreviousPoll.clear();
	}

	public int getCurrentCount() {
		return messageLeftOverFromPreviousPoll.size();
	}
}
