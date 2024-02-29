import requests

def motd():
    response = requests.get('http://127.0.0.1:5000/motd')
    print('MOTD:', response.text)

def version():
    response = requests.get('http://127.0.0.1:5000/version')
    print('Version:', response.text)

if __name__ == '__main__':
    motd()
    version()