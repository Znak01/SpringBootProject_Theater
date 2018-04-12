new Vue({
    el: "#app",
    data: {
        see: false,
        actors: [],
        totalActors: 0,
        perPage: 2,
        currentPage: 1,
        serverUrl: "http://localhost:8090/api/v1"
    },
    methods: {
        getActors: function (page) {
            var self = this;
            let options = {
                params: {
            		page: page,
            		per_page: this.perPage
               }
            }   
            axios.get(this.serverUrl + "/actors", options)
                .then(function (respons) {
                    self.actors = respons.data;
                    self.totalActors = self.actors.length
                    self.currentPage = options.params.page
                    console.log(respons);
                
                })
                .catch(function (error) {
                    console.log(error);
                });

        }
    },
    mounted() {
        this.getActors(this.currentPage);
    }
    });