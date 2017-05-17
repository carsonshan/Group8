import React from 'react';
import LineChart from './charts/LineChart';

class Charts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {data: ''};
        this.state = {
            data: ''
        };

        this.dataSourceHelper = this.dataSourceHelper.bind(this);
    }


    componentWillMount(nextProps) {
        console.log("Calling helper method to fetch data from service.");
        this.dataSourceHelper(nextProps);
    }

    dataSourceHelper(props) {
        props = props || this.props;



        fetch('http://localhost:8000//services/company/GS', {
            method: 'get'
        }).then(function(response) {
            const dataValues = response.json();
            console.log(dataValues);
            var jsonobj = JSON.parse(dataValues);
            console.log(jsonobj);
            this.setState((prevState, props) => ({data: dataValues}));
            //or, this.setState({data: dataValues});
        }).catch(function(err) {

        });

        /**
         * TODO
         * Write a helper method to make an AJAX HTTP request to your service for the
         * company and dates specified in a props parameter.
         *
         * The URL will be on your localhost (e.g. http://localhost:8000/service_path/some_param) where
         * your service is running. Your service MUST be running for the request to work (you can add a catch function
         * to handle errors). Once you make the request, you will want to convert the JSON to a JavaScript
         * object and set in the component state so it can be passed as a prop to your LineChart component.
         *
         * REMEMBER, you'll need to use '=>' if you want to set the state in a callback or promise due
         * to the scope of the 'this' object.
         *
         * Data received should be in a JSON format of
         * {
         *      "dailyClosePrices": [
         *      {
         *         "3/15/2017": 284.97,
         *          "4/6/2017": 152.97,
         *          "4/21/2017": 156.97,
         *          ...
         *      }],
         *      "name": "SOME_STOCK_NAME"
         *  }
         *
         *  Do you need to enable CORS for your service??
         *  https://spring.io/guides/gs/rest-service-cors/#_enabling_cors
         *
         *  Don't forget to bind the helper method in the constructor!
         * */
    }

    render() {
        return
        /**
         * TODO
         * Render your LineChart component and pass the data for the chart to display via props
         */
        <LineChart data=""/>
    }
}


export default Charts;
