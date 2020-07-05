/**
 *  Simulated Switch and Contact Sensor
 *
 *  Copyright 2020 James Mason
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 */
metadata {
	definition (name: "Simulated Switch and Contact Sensor", namespace: "jmason888", author: "James Mason", cstHandler: true) {
		capability "Contact Sensor"
		capability "Switch"
	}


	simulator {
		// TODO: define status and reply messages here
	}

	tiles(scale: 2) {
		standardTile("switch_RO", "device.switch", width: 2, height: 2, decoration: "flat", canChangeIcon: true) {
        	state "off",    label: "off",    icon: "st.switches.switch.off",        backgroundColor: "#79b821" // was "#ffffff"
		 	state "on",     label: "on",     icon: "st.switches.switch.on",         backgroundColor: "#e86d13" // was "#00a0dc"
		}
		standardTile("contact_garage", "device.contact", width: 2, height: 2, canChangeIcon: true) {
        	state "closed", label: "closed", icon: "st.doors.garage.garage-closed", backgroundColor:  "#79b821"
			state "open",   label: "open",   icon: "st.doors.garage.garage-open",   backgroundColor: "#e86d13" // was "#dc243e"
		}
		standardTile("contact_RO", "device.contact", width: 2, height: 2, decoration: "flat", canChangeIcon: true) {
        	state "closed", label: "Closed", icon: "st.contact.contact.closed",     backgroundColor: "#79b821" // was "#00a0dc"
			state "open",   label: "Open",   icon: "st.contact.contact.open",       backgroundColor: "#e86d13"
		}
    	// some text tile "Device is for sync only; should not be manually pressed"
        main('contact_RO')
        details('contact_garage', 'switch_RO')
	}
}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'contact' attribute
	// TODO: handle 'switch' attribute

}

// handle commands

def on() {
	log.debug "Turning Switch and Sensor On"
	sendEvent(name: "switch", value: "on", isStateChange: true, display: true, displayed: true)
	sendEvent(name: "contact", value: "open", isStateChange: true, display: true, displayed: true)
}

def off() {
	log.debug "Turning Switch and Sensor Off"
    sendEvent(name: "switch", value: "off", isStateChange: true, display: true, displayed: true)
    sendEvent(name: "contact", value: "closed", isStateChange: true, display: true, displayed: true)
}

