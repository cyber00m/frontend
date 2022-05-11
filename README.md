# FrontEnd
## Fleet Overview

Map components
shows a map with real-time flights
each plane has an icon with the plane's direction
each plane is clickable and shows minimal details about the flight
the map is adjustable, the user can move it left/right/up/down
the map is rendered every 1 minute
double click on a plane leads to the monitoring page
KPI’s components that show some analytics:
pie chart
bar chart
line chart
graphs are rendered on the app's startup or by clicking the refresh button

## Monitoring

a list of all attributes that we monitor from the flight
each attribute is clickable 
when clicking an attribute, a line chart of this attribute and the most correlative attribute is shown and provides the live line points of those two
a visual line chart of the anomaly detector
a joystick with 2 sliders that shows the aileron, elevator, throttle, and rudder of the plane
6 clocks with some values of the flight
a refresh rate of 10Hz (a parameter that we can change)
BONUS: the image of the cockpit

## Teleoperation

reusable components:
joystick - now the joystick is controlling the plane live!
clocks
a code editor – autopilot (interpeter)

## Time Capsule

reusable components:
joystick - shows recorded flight values of the joystick and the sliders
attributes - can show the attributes of a recorded flight with their graphs
line chart of anomalies
clocks
NEW - video player options: 
play, stop, pause, play forward, play backward
Open file:
CSV flight file
backend saved flight
the flight will be streamed to FlightGear, and we will use FlightGear as a streamer and not as a simulator
connection is directed between frontend and agent

## View Model

Abstraction for the view and for the model
The view model gives commands to the Model
Send notification/events to the view
View + View Model has a data binding between variables. (automatic updates between the view and the view model)

## View

Presentation Logic
UI Components
The view give commands to the View Model

## Model

Get commands from the view model
Ask for data from the backend
Send notifications/events to the view model

## other

Anomaly detector algorisms should be a plugins-compiled class file
use the class loader to load it to the app
each would have learned to detect and draw





