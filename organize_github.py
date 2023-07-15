import requests
import json

import os

url = "https://api.github.com/users/lucasmancan/repos"

payload = {}
headers = {}

response = requests.request("GET", url, headers=headers, data=payload)


json_data = json.loads(response.text)

for repo in json_data:
   # os.system(f'git clone {repo["clone_url"]}')
    print(repo['clone_url'] + " cloned ")

#print(json_data)

