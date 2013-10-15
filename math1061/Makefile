all: midsem.pdf week2.pdf week3.pdf week4.pdf week5.pdf week6.pdf sets.pdf week9.pdf 2013-2-week10.pdf week10.pdf challenges.pdf summary.pdf exam_sample.pdf week12.pdf

%.pdf: src/%.tex
	pdflatex $<

clean:
	rm *.{aux,log,nav,out,snm,toc,pdf}
