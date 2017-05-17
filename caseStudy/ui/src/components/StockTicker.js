import React from 'react';
import {Typeahead} from 'react-bootstrap-typeahead';

/* If you chose to use react-boostrap-typeahead, look at AsyncTypeahead for a component that
 * provides auto-complete suggestions as you type. This would require adding a search handler
 * method for an onSearch prop.
 * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/example/examples/AsyncExample.react.js
 */

class StockTicker extends React.Component {

    /**
     * TODO
     * Prefetch the data required to display options fo the typeahead component. Initialize a state array with
     * this data and pass it via props to the typeahead component that will be rendered.
     * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/docs/Data.md
     * e.g.
     * options : [
     *   GS,
     *   AAPL,
     *   FB,
     * ]
     * If you are having difficulty with this, you may hard code the options array from the company data provided for the
     * services.
     */
    constructor(props) {
        super(props);
        this.state = {
            showcompanyinfo: false, //TODO: Use this boolean to determine if the company information should be rendered
            company : {
                symbol: '',
                name: '',
                city: '',
                state: '',
                sector: '',
                industry: ''
            },
            options: []
            /**
             * TODO
             * Add any additional state to pass via props to the typeahead component.
             */
        };
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        if (event.length > 0) {
            /**
             * TODO
             * Make a request to your service to GET company information for the selected company and set it in state.
             * The information you will need to determine the URL will be contained in the 'event[0]' object,
             * e.g. event[0] (event[0].symbol if your options are an array of objects) provides you the symbol selected.
             * The URL will be on your localhost (e.g. http://localhost:8000/service_path/some_param) where
             * your service is running. Your service MUST be running for the request to work (you can add a catch function
             * to handle errors). If you successfully retrieve this information, you can set the state objects
             * and render it.
             */

            this.setState()
            var symbol = event[0].symbol;
            console.log(symbol);

            fetch('http://localhost:8000/services/company/' + symbol, {
                method: 'get'
            }).then(function(response) {
                const companyValues = response.json();
                console.log(companyValues);
                this.setState({showcompanyinfo: true, company: companyValues});
            }).catch(function(err) {
                console.log("error");
            });
            this.props.onChange(symbol);
        }
        else {
            this.setState({showinfo: false});
            this.props.onChange(undefined);
        }
    }


    render() {

        /**
         * TODO
         * Render a typeahead component that uses the data prefetched from your service to display a list of companies or
         * ticker symbols. The props you use can be stored as state objects.
         * On change should fetch the company information and display Company, Ticker Symbol, City, State/Country, Sector, and Industry information.
         * https://github.com/ericgio/react-bootstrap-typeahead/blob/master/docs/Props.md
         */

        return (
            <div className="stockticker">
                <div className="ticker-input">
                    <p><strong>Stock Ticker</strong></p>
                    <div className="stockticker-typeahead">
                        {
                            <Typeahead
                                labelKey={this.state.company.symbol}
                                onChange={this.handleChange}
                                placeholder="Company Name/Ticker"
                                options={this.state.options}
                            />
                        }
                    </div>
                </div>
                {
                    /**
                     *  TODO
                     *  Create a div element that shows a company information when the ticker changes. You will need to use a conditional here
                     *  to help control rendering and pass these states as props to the component. This conditional can
                     *  be maintained as a state object.
                     *  http://reactpatterns.com/#conditional-rendering
                     */

                }
                {showCompanyInfo ?
                    <div><p>Coming Soon</p></div> :
                    <div></div>
                }
            </div>
        );
    }

}

//Don't forget to export your component!
export default StockTicker;
