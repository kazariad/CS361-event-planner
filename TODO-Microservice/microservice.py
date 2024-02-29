from flask import Flask
import random

app = Flask(__name__)

messages = [
    "Coming soon: Add images and video to your events.",
    "Coming soon: Export your data to a local file.",
    "Tip: Click the Help button to view the user guide."
]

@app.route('/motd')
def motd():
    return random.choice(messages), 200

@app.route('/version')
def version():
    return "v1.0", 200

if __name__ == '__main__':
    app.run(debug=True)