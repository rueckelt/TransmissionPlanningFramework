
% 2016-10-14 13:52:05

% my_logs/jakob/2_2_2/rep_605/Greedy_0_H2_FNGT_log.m
scheduling_duration_us = 16161;

% schedule
schedule_f_t_n(:,:,1) = [0, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 59, 0, 0, 0; 24, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,2) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,3) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 7, 0, 0, 0; 0, 0, 0, 7; 0, 0, 0, 7; 0, 0, 0, 7; 0, 0, 0, 7; 0, 0, 0, 7; 0, 0, 0, 7; 0, 0, 0, 7; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 0, 7, 0, 0; 0, 7, 0, 0; 0, 7, 0, 0; 0, 7, 0, 0; 0, 7, 0, 0; 0, 7, 0, 0; 0, 0, 7, 0; 0, 0, 7, 0; 0, 0, 7, 0; 0, 0, 7, 0; 0, 0, 7, 0; 0, 0, 7, 0; 0, 0, 7, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 7, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,4) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 52, 0, 0, 0; 52, 0, 0, 0; 52, 0, 0, 0; 52, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];

% cost function results
vioSt = [0, 0, 0, 0];
vioDl = [0, 0, 0, 0];
vioNon = [0, 5610, 780, 143232];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 61, 85, 85, 85, 85, 85, 85, 85, 85, 85, 85, 85, 85, 85, 85, 85, 85, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [501, 0, 0, 0];
vioLcy = [0, 0, 4131, 0];
vioJit = [0, 0, 4248, 0];
cost_vio = 1258785;
cost_switches = 5000;
cost_ch = 406845;
costTotal = 1670630;

% Greedy_0_H2_FNGT
% 
% ############### Network 0 ##############
% cap	|[0]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[10]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[20]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[30]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[40]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[50]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[60]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[70]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[80]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[90]59	|59	|59	|59	|59	|59	|59	|59	|59	|59	|
% F0	|[0]	|59	|59	|59	|59	|59	|59	|59	|59	|59	|[10]59	|59	|59	|59	|59	|24	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|7	|	|	|	|	|	|	|	|7	|[30]7	|7	|7	|7	|7	|7	|7	|7	|7	|7	|[40]7	|7	|7	|7	|7	|7	|7	|7	|7	|7	|[50]7	|7	|7	|7	|7	|7	|7	|7	|7	|7	|[60]7	|7	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|7	|7	|7	|7	|7	|[80]7	|7	|7	|7	|7	|7	|7	|7	|7	|7	|[90]7	|7	|	|	|	|	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|52	|52	|[60]52	|52	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 1 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|10	|20	|20	|20	|20	|10	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|7	|7	|7	|7	|7	|7	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 2 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|30	|60	|[70]60	|60	|60	|60	|30	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|7	|7	|[70]7	|7	|7	|7	|7	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 3 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|25	|51	|51	|51	|51	|51	|25	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|7	|7	|7	|7	|7	|7	|7	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|

