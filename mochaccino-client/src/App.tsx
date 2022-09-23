import React from 'react';
import axios from "axios";
import "./App.css";

function App() {

  const handleDownload = () => {
      let body = {providers: ["firstName", "lastName", "zipCode"], "limit": 1000};
      axios.post("https://mochaccino-server.herokuapp.com/data/download?format=csv", body,
          {
              headers: {
                  "Content-Type": "application/json"
              }
          }).then((response) => {
          console.log(response.headers);
          const contentDispositionHeader = response.headers['content-disposition'];
          const fileFormat = contentDispositionHeader.split('.')[1].slice(0, -1);
          console.log(fileFormat);
          const url = window.URL.createObjectURL(new Blob([response.data]));
          const link = document.createElement('a');
          link.href = url;
          const desiredFileFormat = 'data.' + fileFormat;
          link.setAttribute('download', desiredFileFormat);
          document.body.appendChild(link);
          link.click();
      }).catch(err => {
          console.log(err.status)
      })
  }

  return (
    <div className="App">
      <button onClick={() => handleDownload()}>
        Download data!
      </button>
    </div>
  );
}

export default App;
