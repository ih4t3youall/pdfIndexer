<link rel="stylesheet" href="resources/metrostyle/css/site.css" type="text/css" />
    <link rel="stylesheet" href="resources/metrostyle/css/dg-font-awesome.min.css" type="text/css">
    <!--[if IE 7]>
    <link rel="stylesheet" href="/content/fa/assets/css/dg-font-awesome-ie7.min.css">
    <![endif]-->
    <link rel="stylesheet" href="resources/metrostyle/metrojs/MetroJs.min.css" type="text/css" />    
    
    <script type="text/javascript">
  
    
    
    
        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-27990990-1']);
        _gaq.push(['_trackPageview']);

        (function () {
            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
        })();
        function trackExternal(link, prefix) {
            try {
                if (typeof prefix == "undefined" || prefix == null)
                    prefix = "";
                var href = link.href.replace(/(http)(s)?:\/\/(www\.)?/i, "/outgoing/" + prefix);
                _gaq.push(['_trackPageview', href]);
            }
            catch (err) { }
        }
	</script>
    <script type="text/javascript" src="resources/metrostyle/script/modernizr-2.5.3.js"></script>
    
    
    
    
    <!-- aca empiza -->
    
    <script src="resources/metrostyle/metrojs/MetroJs.js" type="text/javascript"></script>
    <script type="text/javascript">
        var metroJs,
            appBar;
        // remove the default theme set for noscript and apply user theme
        $(document).ready(function () {
        	
            $("body,.tiles").removeClass("dark blue");
            metroJs = jQuery.fn.metrojs;
            metroJs.theme.loadDefaultTheme();
        });
    </script>
        
    <script type="text/javascript" src="resources/metrostyle/script/home.index.js"></script>

    <script type="text/javascript">        
        
        $(document).ready(function () {

        	
        	
            var doBind = (typeof (window.bindAppBarKeyboard) === "undefined" || window.bindAppBarKeyboard);
            // create the app bar
            appBar = $(".appbar").applicationBar({
	    	applyTheme: false, // apply theme example below
                preloadAltBaseTheme: true, // load both sets of images so there isn't a flicker when base theme is changed
                metroLightUrl: '/images/metroIcons_light.jpg',
                metroDarkUrl: '/images/metroIcons.jpg',
                bindKeyboard: doBind // bind the keyboard unless specified in an included script
            });
            // add the accents and base colors to the appbar
            metroJs.theme.appendAccentColors();
            metroJs.theme.appendBaseThemes();
        });
        

	</script>
    <script type="text/javascript" src="resources/metrostyle/script/jquery.mousewheel.min.js"></script>
    <script type="text/javascript" src="resources/metrostyle/script/global.js"></script>
    