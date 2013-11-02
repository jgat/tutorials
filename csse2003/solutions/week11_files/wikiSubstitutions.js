(function() {
  var conditionallyInsertMathJax, conditionallyInsertPrettify, insertYouTube, linkLookup, processLinks, processTemplates;
  linkLookup = function(el) {
    var data, link;
    link = $(this);
    data = {
      topic: link.attr("data-ib-topic"),
      noun: link.attr("data-ib-noun"),
      adj: link.attr("data-ib-adj"),
      site: link.attr("data-ib-site"),
      entryId: link.attr("data-ib-entryid")
    };
    return parent.IBViewer.lookupCE(data);
  };
  processLinks = function() {
    return $("a[data-ib-topic]").add("a[data-ib-entryid]").on("click", linkLookup);
  };
  conditionallyInsertPrettify = function() {
    if ($(".prettyprint").length > 0) {
      $("head").append("<link href='/assets/lib/prettify/prettify.css' type='text/css' rel='stylesheet' />");
      $("body").append("<script type='text/javascript' src='/assets/lib/prettify/prettify.js'></script>");
      return $("body").append("<script>prettyPrint();</script>");
    }
  };
  conditionallyInsertMathJax = function() {
    if ($(".mathjax").length > 0) {
      return $("head").append('<script type="text/javascript"\
                            src="http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS-MML_HTMLorMML">\
                          </script>');
    }
  };
  processTemplates = function() {
    return $("[data-ib-template]").each(function(index, element) {
      var jqEl, template;
      jqEl = $(this);
      template = jqEl.attr("data-ib-template");
      if (template === "youtube") {
        return insertYouTube(jqEl);
      }
    });
  };
  insertYouTube = function(jqEl) {
    var templ, videoId;
    videoId = jqEl.attr("data-ib-value");
    templ = '<iframe src="http://www.youtube.com/embed/THEKEY?rel=0" frameborder="0" allowfullscreen></iframe>';
    return jqEl.html(templ.replace("THEKEY", videoId));
  };
  $(document).ready(function() {
    processLinks();
    conditionallyInsertPrettify();
    conditionallyInsertMathJax();
    return processTemplates();
  });
  window.IBWikiSubstitutions = {
    pushPrevNextAnchors: function() {
      return $(".ib-prevnext[id]").each(function(idx, el) {
        return parent.IBPrevNext.push("anchor", $(el).attr("id"));
      });
    }
  };
}).call(this);
